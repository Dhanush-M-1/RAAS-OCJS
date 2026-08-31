#include<bits/stdc++.h>
int i,j,p,n,q,a[9]={5,7,5,7,7,-1};char s[50];
int main(){for(;scanf("%d\n",&n),n;){for(i=0;i<n;s[i++]=strlen(gets(s+i)));
for(i=j=0;j<6;i++)for(p=i,j=q=0;q>=0;)for(q=a[j++];q>0;q-=s[p++]);
printf("%d\n",i);
}}