package com.dnob.bahuiBot.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.nio.channels.Channel;
import java.util.List;

public class listen extends ListenerAdapter {


    @Override
    public void onReady(ReadyEvent event)
    {
        System.out.println("I am ready to go!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        System.out.printf("[%s]: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
    }



    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {



        List<Member> member = event.getGuild().getMembers();
        User user = event.getMember().getUser();
        String message = user.getAsMention() + " Нахуй отсюда! Мусор бесполезный! " + " https://media.discordapp.net/attachments/827021321120382986/1015368145084616785/gifntext-gif_2.gif ";
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();

        }


    }




