#include<cstdio>
int main(void){char buf1;int n,c[53]={0},i,buf2;scanf("%d",&n);for(i=0;i<n;++i){scanf("%c",&buf1);scanf("%c %d",&buf1,&buf2);++c[((buf1=='S')?0:((buf1=='H')?13:((buf1=='C')?26:39)))+buf2];}for(i=1;i<=52;++i){if(!c[i]){printf("%c %d\n",(((i-1)/13)==0)?'S':(((i-1)/13)==1)?'H':(((i-1)/13)==2)?'C':'D', ((i-1)%13)+1);}}return(0);}
