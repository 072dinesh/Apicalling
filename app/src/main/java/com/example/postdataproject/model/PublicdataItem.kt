package com.example.postdataproject.model


import com.google.gson.annotations.SerializedName
import kotlin.collections.Collection

data class PublicdataItem(
    @SerializedName("apple_news_notices")
    val appleNewsNotices: List<Any?>?,
    @SerializedName("associatedEvent")
    val associatedEvent: Any?,
    @SerializedName("author")
    val author: Int?,
    @SerializedName("authors")
    val authors: List<Int?>?,
    @SerializedName("canonical_url")
    val canonicalUrl: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("editorialContentProvider")
    val editorialContentProvider: String?,
    @SerializedName("event")
    val event: Any?,
    @SerializedName("excerpt")
    val excerpt: Excerpt?,
    @SerializedName("featured")
    val featured: Boolean?,
    @SerializedName("featured_media")
    val featuredMedia: Int?,
    @SerializedName("hide_featured_image")
    val hideFeaturedImage: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("jetpack_featured_media_url")
    val jetpackFeaturedMediaUrl: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("_links")
    val links: Links?,
    @SerializedName("parsely")
    val parsely: Parsely?,
    @SerializedName("parselyMeta")
    val parselyMeta: ParselyMeta?,
    @SerializedName("premiumContent")
    val premiumContent: Boolean?,
    @SerializedName("premiumCutoffPercent")
    val premiumCutoffPercent: Int?,
    @SerializedName("primary_category")
    val primaryCategory: PrimaryCategory?,
    @SerializedName("rapidData")
    val rapidData: RapidData?,
    @SerializedName("shortlink")
    val shortlink: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("subtitle")
    val subtitle: String?,
    @SerializedName("tc_cb_mapping")
    val tcCbMapping: List<Any?>?,
    @SerializedName("title")
    val title: Title?,
    @SerializedName("type")
    val type: String?
)

data class PrimaryCategory(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("filter")
    val filter: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("parent")
    val parent: Int?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("taxonomy")
    val taxonomy: String?,
    @SerializedName("term_group")
    val termGroup: Int?,
    @SerializedName("term_id")
    val termId: Int?,
    @SerializedName("term_taxonomy_id")
    val termTaxonomyId: Int?
)

data class PredecessorVersion(
    @SerializedName("href")
    val href: String?,
    @SerializedName("id")
    val id: Int?
)

data class ParselyMeta(
    @SerializedName("parsely-author")
    val parselyAuthor: List<String?>?,
    @SerializedName("parsely-image-url")
    val parselyImageUrl: String?,
    @SerializedName("parsely-link")
    val parselyLink: String?,
    @SerializedName("parsely-metadata")
    val parselyMetadata: String?,
    @SerializedName("parsely-pub-date")
    val parselyPubDate: String?,
    @SerializedName("parsely-section")
    val parselySection: String?,
    @SerializedName("parsely-tags")
    val parselyTags: String?,
    @SerializedName("parsely-title")
    val parselyTitle: String?,
    @SerializedName("parsely-type")
    val parselyType: String?
)

data class Parsely(
    @SerializedName("meta")
    val meta: List<Any?>?,
    @SerializedName("rendered")
    val rendered: String?,
    @SerializedName("version")
    val version: String?
)

data class Links(
    @SerializedName("about")
    val about: List<About?>?,
    @SerializedName("author")
    val author: List<Author?>?,
    @SerializedName("authors")
    val authors: List<Author?>?,
    @SerializedName("collection")
    val collection: List<com.example.postdataproject.model.Collection?>?,
    @SerializedName("curies")
    val curies: List<Cury?>?,
    @SerializedName("https://techcrunch.com/edit")
    val httpsTechcrunchComedit: List<HttpsTechcrunchComedit?>?,
    @SerializedName("predecessor-version")
    val predecessorVersion: List<PredecessorVersion?>?,
    @SerializedName("replies")
    val replies: List<Reply?>?,
    @SerializedName("self")
    val self: List<Self?>?,
    @SerializedName("version-history")
    val versionHistory: List<VersionHistory?>?,
    @SerializedName("wp:attachment")
    val wpAttachment: List<WpAttachment?>?,
    @SerializedName("wp:featuredmedia")
    val wpFeaturedmedia: List<WpFeaturedmedia?>?,
    @SerializedName("wp:term")
    val wpTerm: List<WpTerm?>?
)

data class HttpsTechcrunchComedit(
    @SerializedName("href")
    val href: String?
)

data class Excerpt(
    @SerializedName("protected")
    val `protected`: Boolean?,
    @SerializedName("rendered")
    val rendered: String?
)
data class Cury(
    @SerializedName("href")
    val href: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("templated")
    val templated: Boolean?
)

data class Collection(
    @SerializedName("href")
    val href: String?
)

data class Author(
    @SerializedName("embeddable")
    val embeddable: Boolean?,
    @SerializedName("href")
    val href: String?
)

data class About(
    @SerializedName("href")
    val href: String?
)

data class RapidData(
    @SerializedName("pct")
    val pct: String?,
    @SerializedName("pt")
    val pt: String?
)

data class Reply(
    @SerializedName("embeddable")
    val embeddable: Boolean?,
    @SerializedName("href")
    val href: String?
)


data class Self(
    @SerializedName("href")
    val href: String?
)
data class Title(
    @SerializedName("rendered")
    val rendered: String?
)

data class VersionHistory(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("href")
    val href: String?
)

data class WpAttachment(
    @SerializedName("href")
    val href: String?
)

data class WpFeaturedmedia(
    @SerializedName("embeddable")
    val embeddable: Boolean?,
    @SerializedName("href")
    val href: String?
)

data class WpTerm(
    @SerializedName("embeddable")
    val embeddable: Boolean?,
    @SerializedName("href")
    val href: String?,
    @SerializedName("taxonomy")
    val taxonomy: String?
)