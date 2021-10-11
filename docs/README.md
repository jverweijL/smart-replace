# Smart Replace
With this module you can replace placeholders like ${sample_text}.
This will allow you to reuse content in different sites where maybe a link should be different.
Like step number 7 in https://um.fi/residence-permits-to-finland and https://finlandabroad.fi/web/gbr/residence-permits-to-finland

## Web Content Template
To make sure the variables are replaced you can use the following

```injectedfreemarker
${content.getData()?replace(r"${sample_text}", sample_text)}
```

But even better is to use the smartReplaceAll method like
```injectedfreemarker
${smartReplace.smartReplaceAll(content.getData())}
```

## Filter
Alternatively you can also use a filter