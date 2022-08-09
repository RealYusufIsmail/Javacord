package org.javacord.api.util.internal;

import org.javacord.api.DiscordApi;
import org.javacord.api.audio.internal.AudioSourceBaseDelegate;
import org.javacord.api.entity.channel.*;
import org.javacord.api.entity.channel.internal.*;
import org.javacord.api.entity.emoji.KnownCustomEmoji;
import org.javacord.api.entity.emoji.internal.CustomEmojiBuilderDelegate;
import org.javacord.api.entity.emoji.internal.CustomEmojiUpdaterDelegate;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.component.internal.*;
import org.javacord.api.entity.message.embed.internal.EmbedBuilderDelegate;
import org.javacord.api.entity.message.internal.InteractionMessageBuilderDelegate;
import org.javacord.api.entity.message.internal.MessageBuilderBaseDelegate;
import org.javacord.api.entity.message.internal.WebhookMessageBuilderDelegate;
import org.javacord.api.entity.message.mention.internal.AllowedMentionsBuilderDelegate;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.permission.internal.PermissionsBuilderDelegate;
import org.javacord.api.entity.permission.internal.RoleBuilderDelegate;
import org.javacord.api.entity.permission.internal.RoleUpdaterDelegate;
import org.javacord.api.entity.server.ScheduledEvent;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.internal.EventBuilderDelegate;
import org.javacord.api.entity.server.internal.EventUpdaterDelegate;
import org.javacord.api.entity.server.internal.ServerBuilderDelegate;
import org.javacord.api.entity.server.internal.ServerUpdaterDelegate;
import org.javacord.api.entity.server.invite.internal.InviteBuilderDelegate;
import org.javacord.api.entity.sticker.internal.StickerBuilderDelegate;
import org.javacord.api.entity.sticker.internal.StickerUpdaterDelegate;
import org.javacord.api.entity.webhook.Webhook;
import org.javacord.api.entity.webhook.internal.WebhookBuilderDelegate;
import org.javacord.api.entity.webhook.internal.WebhookUpdaterDelegate;
import org.javacord.api.interaction.internal.*;
import org.javacord.api.internal.AccountUpdaterDelegate;
import org.javacord.api.internal.DiscordApiBuilderDelegate;
import org.javacord.api.util.exception.DiscordExceptionValidator;
import org.javacord.api.util.logging.internal.ExceptionLoggerDelegate;

/**
 * This class is internally used by the {@link DelegateFactory} to create delegate instances.
 * You usually don't want to interact with this object.
 */
public interface DelegateFactoryDelegate {

    /**
     * Creates a new discord api builder delegate.
     *
     * @return A new discord api builder delegate.
     */
    DiscordApiBuilderDelegate createDiscordApiBuilderDelegate();

    /**
     * Creates a new embed builder delegate.
     *
     * @return A new embed builder delegate.
     */
    EmbedBuilderDelegate createEmbedBuilderDelegate();

    /**
     * Creates a new mention builder delegate.
     *
     * @return A new mention builder delegate.
     */
    AllowedMentionsBuilderDelegate createAllowedMentionsBuilderDelegate();

    /**
     * Creates a new message builder delegate.
     *
     * @return A new message builder delegate.
     */
    MessageBuilderBaseDelegate createMessageBuilderDelegate();

    /**
     * Creates a new interaction message builder delegate.
     *
     * @return A new interaction message builder delegate.
     */
    InteractionMessageBuilderDelegate createInteractionMessageBuilderDelegate();

    /**
     * Creates a new webhook message builder delegate.
     *
     * @return A new webhook message builder delegate.
     */
    WebhookMessageBuilderDelegate createWebhookMessageBuilderDelegate();

    /**
     * Creates a new permissions builder delegate.
     *
     * @return A new permissions builder delegate.
     */
    PermissionsBuilderDelegate createPermissionsBuilderDelegate();

    /**
     * Creates a new permissions builder delegate initialized with the given permissions.
     *
     * @param permissions The permissions which should be copied.
     * @return A new permissions builder delegate initialized with the given permissions.
     */
    PermissionsBuilderDelegate createPermissionsBuilderDelegate(Permissions permissions);

    /**
     * Creates a new channel category builder delegate.
     *
     * @param server The server of the channel category.
     * @return A new channel category builder delegate.
     */
    ChannelCategoryBuilderDelegate createChannelCategoryBuilderDelegate(Server server);

    /**
     * Creates a new server text channel builder delegate.
     *
     * @param server The server of the server text channel.
     * @return A new server text channel builder delegate.
     */
    ServerTextChannelBuilderDelegate createServerTextChannelBuilderDelegate(Server server);

    /**
     * Creates a new server forum channel builder delegate.
     *
     * @param server The server of the server forum channel.
     * @return A new server forum channel builder delegate.
     */
    ServerForumChannelBuilderDelegate createServerForumChannelBuilderDelegate(Server server);

    /**
     * Creates a new server thread channel builder delegate.
     *
     * @param serverTextChannel The server text channel where the thread will be created in.
     * @return A new server thread channel builder delegate.
     */
    ServerThreadChannelBuilderDelegate createServerThreadChannelBuilderDelegate(
            ServerTextChannel serverTextChannel);

    /**
     * Creates a new server thread channel builder delegate.
     *
     * @param message The message where this thread should be created for.
     * @return A new server thread channel builder delegate.
     */
    ServerThreadChannelBuilderDelegate createServerThreadChannelBuilderDelegate(Message message);

    /**
     * Creates a new server voice channel builder delegate.
     *
     * @param server The server of the server voice channel.
     * @return A new server voice channel builder delegate.
     */
    ServerVoiceChannelBuilderDelegate createServerVoiceChannelBuilderDelegate(Server server);

    /**
     * Creates a new custom emoji builder delegate.
     *
     * @param server The server of the custom emoji.
     * @return A new custom emoji builder delegate.
     */
    CustomEmojiBuilderDelegate createCustomEmojiBuilderDelegate(Server server);

    /**
     * Creates a new webhook builder delegate.
     *
     * @param channel The server text channel of the webhook.
     * @return A new webhook builder delegate.
     */
    WebhookBuilderDelegate createWebhookBuilderDelegate(ServerTextChannel channel);

    /**
     * Creates a new server builder delegate.
     *
     * @param api The discord api instance.
     * @return A new server builder delegate.
     */
    ServerBuilderDelegate createServerBuilderDelegate(DiscordApi api);

    /**
     * Creates a new role builder delegate.
     *
     * @param server The server for which the role should be created.
     * @return A new role builder delegate.
     */
    RoleBuilderDelegate createRoleBuilderDelegate(Server server);

    /**
     * Creates a new invite builder delegate.
     *
     * @param channel The channel for the invite.
     * @return A new invite builder delegate.
     */
    InviteBuilderDelegate createInviteBuilderDelegate(ServerChannel channel);

    /**
     * Creates a new account updater delegate.
     *
     * @param api The discord api instance.
     * @return A new account updater delegate.
     */
    AccountUpdaterDelegate createAccountUpdaterDelegate(DiscordApi api);

    /**
     * Creates a new slash command updater delegate.
     *
     * @param commandId The slash command id.
     * @return A new slash command updater delegate.
     */
    SlashCommandUpdaterDelegate createSlashCommandUpdaterDelegate(long commandId);

    /**
     * Creates a new user context menu updater delegate.
     *
     * @param commandId The application command id.
     * @return A new user context menu updater delegate.
     */
    UserContextMenuUpdaterDelegate createUserContextMenuUpdaterDelegate(long commandId);

    /**
     * Creates a new message context menu updater delegate.
     *
     * @param commandId The application command id.
     * @return A new message context menu updater delegate.
     */
    MessageContextMenuUpdaterDelegate createMessageContextMenuUpdaterDelegate(long commandId);

    /**
     * Creates a new server channel updater delegate.
     *
     * @param channel The channel to update.
     * @return A new server channel updater delegate.
     */
    ServerChannelUpdaterDelegate createServerChannelUpdaterDelegate(ServerChannel channel);

    /**
     * Creates a new regular server channel updater delegate.
     *
     * @param channel The channel to update.
     * @return A new server channel updater delegate.
     */
    RegularServerChannelUpdaterDelegate createRegularServerChannelUpdaterDelegate(
            RegularServerChannel channel);

    /**
     * Creates a new server text channel updater delegate.
     *
     * @param channel The channel to update.
     * @return A new server text channel updater delegate.
     */
    ServerTextChannelUpdaterDelegate createServerTextChannelUpdaterDelegate(ServerTextChannel channel);

    /**
     * Creates a new server forum channel updater delegate.
     *
     * @param channel The channel to update.
     * @return A new server forum channel updater delegate.
     */
    ServerForumChannelUpdaterDelegate createServerForumChannelUpdaterDelegate(ServerForumChannel channel);

    /**
     * Creates a new server voice channel updater delegate.
     *
     * @param channel The channel to update.
     * @return A new server voice channel updater delegate.
     */
    ServerVoiceChannelUpdaterDelegate createServerVoiceChannelUpdaterDelegate(ServerVoiceChannel channel);

    /**
     * Creates a new server thread channel updater delegate.
     *
     * @param thread The thread to update.
     * @return A new server thread channel updater delegate.
     */
    ServerThreadChannelUpdaterDelegate createServerThreadChannelUpdaterDelegate(ServerThreadChannel thread);

    /**
     * Creates a new custom emoji updater delegate.
     *
     * @param emoji The custom emoji to update.
     * @return A new custom emoji updater delegate.
     */
    CustomEmojiUpdaterDelegate createCustomEmojiUpdaterDelegate(KnownCustomEmoji emoji);

    /**
     * Creates a new role updater delegate.
     *
     * @param role The role to update.
     * @return A new role updater delegate.
     */
    RoleUpdaterDelegate createRoleUpdaterDelegate(Role role);

    /**
     * Creates a new server updater delegate.
     *
     * @param server The server to update.
     * @return A new server updater delegate.
     */
    ServerUpdaterDelegate createServerUpdaterDelegate(Server server);

    /**
     * Creates a new webhook updater delegate.
     *
     * @param webhook The webhook to update.
     * @return A new webhook updater delegate.
     */
    WebhookUpdaterDelegate createWebhookUpdaterDelegate(Webhook webhook);

    /**
     * Creates a new audio source base delegate.
     *
     * @param api The discord api instance.
     * @return A new audio source base delegate.
     */
    AudioSourceBaseDelegate createAudioSourceBaseDelegate(DiscordApi api);

    /**
     * Creates a new exception logger delegate.
     *
     * @return A new exception logger delegate.
     */
    ExceptionLoggerDelegate createExceptionLoggerDelegate();

    /**
     * Creates a new discord exception validator.
     *
     * @return A new discord exception validator.
     */
    DiscordExceptionValidator createDiscordExceptionValidator();

    /**
     * Creates a new slash command builder delegate.
     *
     * @return The slash command builder delegate.
     */
    SlashCommandBuilderDelegate createSlashCommandBuilderDelegate();

    /**
     * Creates a new user context menu builder delegate.
     *
     * @return The user context menu builder delegate.
     */
    UserContextMenuBuilderDelegate createUserContextMenuBuilderDelegate();

    /**
     * Creates a new message context menu builder delegate.
     *
     * @return The message context menu builder delegate.
     */
    MessageContextMenuBuilderDelegate createMessageContextMenuBuilderDelegate();

    /**
     * Creates a new slash command option builder delegate.
     *
     * @return The slash command option builder delegate.
     */
    SlashCommandOptionBuilderDelegate createSlashCommandOptionBuilderDelegate();

    /**
     * Creates a new slash command option choice builder delegate.
     *
     * @return The slash command option choice builder delegate.
     */
    SlashCommandOptionChoiceBuilderDelegate createSlashCommandOptionChoiceBuilderDelegate();


    /**
     * Creates a new ActionRow builder delegate.
     *
     * @return A new ActionRow builder delegate.
     */
    ActionRowBuilderDelegate createActionRowBuilderDelegate();

    /**
     * Creates a new Button builder delegate.
     *
     * @return A new Button builder delegate.
     */
    ButtonBuilderDelegate createButtonBuilderDelegate();

    /**
     * Creates a new TextInput builder delegate.
     *
     * @return A new TextInput builder delegate.
     */
    TextInputBuilderDelegate createTextInputBuilderDelegate();

    /**
     * Creates a new select menu builder delegate.
     *
     * @return A new select menu builder delegate.
     */
    SelectMenuBuilderDelegate createSelectMenuBuilderDelegate();

    /**
     * Creates a new select menu option builder delegate.
     *
     * @return A new select menu option builder delegate.
     */
    SelectMenuOptionBuilderDelegate createSelectMenuOptionBuilderDelegate();

    /**
     * Creates a new sticker builder delegate.
     *
     * @param server The server that owns the sticker.
     * @return A new sticker builder delegate.
     */
    StickerBuilderDelegate createStickerBuilderDelegate(Server server);

    /**
     * Creates a new sticker sticker updater delegate.
     *
     * @param server The server that owns the sticker.
     * @param id     The ID of the sticker.
     * @return A new sticker updater delegate.
     */
    StickerUpdaterDelegate createStickerUpdaterDelegate(Server server, long id);

    EventBuilderDelegate createEventBuilderDelegate(Server server);

    EventUpdaterDelegate createEventUpdaterDelegate(Server server, ScheduledEvent event);
}
