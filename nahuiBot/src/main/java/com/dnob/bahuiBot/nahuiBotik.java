package com.dnob.bahuiBot;

import com.dnob.bahuiBot.listeners.listen;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class nahuiBotik {

    private final ShardManager shardManager;
    private final Dotenv config;

    public nahuiBotik() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");


        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.listening("Red Right Hand"));
        builder.setMemberCachePolicy(MemberCachePolicy.VOICE);
        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.enableCache(CacheFlag.VOICE_STATE);
        shardManager = builder.build();


        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        shardManager.addEventListener(new listen());



    }


    public Dotenv getConfig(){
        return config;
    }

    public ShardManager getShardManager(){
        return shardManager;
    }

    public static void main(String[] args){
        try {

            nahuiBotik bot = new nahuiBotik();
        } catch (LoginException e){
            System.out.println("ERROR: TOKEN IS INVALIDED");
        }
    }
}
