#include<bits/stdc++.h>
char s[50],a[9]={6,8,6,8,8};
int main(){for(int i,j,p,n,q;scanf("%d\n",&n),n;){for(i=0;i<n;s[i++]=strlen(gets(s+i)));
for(i=j=0;j<6;i++)for(p=i,j=q=0;q>=0;)for(q=a[j++]-1;q>0;q-=s[p++]);
printf("%d\n",i);
}}