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