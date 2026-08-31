#include<bits/stdc++.h>
#define f(X) for(c=0;c<X;c+=v[p++]);if(c-X)goto L;
int main(){for(char n,v[99],s,p,c;n=atoi(gets(v));){for(s=0;s<n;v[++s]=strlen(gets(v+n)));s=0;L:p=++s;f(5)f(7)f(5)f(7)f(7)printf("%d\n",s);}}