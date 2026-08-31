#include<bits/stdc++.h>
#define mo 1000000007
#define pi 3.1415926535898
#define eps 1e-9 
using namespace std;
long long read(){
    long long xx=0,flagg=1;
    char ch=getchar();
    while((ch<'0'||ch>'9')&&ch!='-')
        ch=getchar();
    if(ch=='-'){
        flagg=-1;
        ch=getchar();
    }
    while(ch>='0'&&ch<='9'){
        xx=xx*10+ch-'0';
        ch=getchar();
    }
    return xx*flagg;
}
void pus(long long xx,long long flagg){
    if(xx<0){
        putchar('-');
        xx=-xx;
    }
    if(xx>=10)
        pus(xx/10,0);
    putchar(xx%10+'0');
    if(flagg==1)
        putchar(' ');
    if(flagg==2)
        putchar('\n');
    return;
}
int X,n,m,i,r[100005],L,R,ti,a,flag,x,sum;
int cz(int u,int v,int w){
	return max(u,min(v,w));
}
int main(){
   	X=read();n=read();
    for(i=1;i<=n;i++)
    	r[i]=read();
    m=read();
   	R=X;i=0;flag=-1;
    while(m--){
        ti=read();a=read();
        while(i<n&&r[i+1]<=ti){
            x=flag*(r[i+1]-r[i]);
            L=cz(0,X,L+x);
            R=cz(0,X,R+x);
            flag=-flag;
            sum+=x;
            i++;
        }
        pus(cz(0,X,cz(L,R,a+sum)+flag*(ti-r[i])),2);
    }
    return 0;
}