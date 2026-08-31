#include <bits/stdc++.h>
#define ll long long
using namespace std;
int x,k,r[100005],t,num;
inline int read()
{int x=0;
char c=getchar();
while (c<'0'||c>'9') c=getchar();
while (c>='0'&&c<='9') x=x*10+c-'0',c=getchar();
return x;
}
int main (){
	int i,j,q;
	x=read();k=read();
	for (i=1;i<=k;i++)
	{r[i]=read();}
	int a,minn=0,maxn=x,pos=1,ansmin=0,ansmax=x,num=0;
	q=read();
	while (q--)
	{t=read();a=read();
	while (pos<=k&&r[pos]<t)
	{ansmin-=(r[pos]-r[pos-1]);
	if (ansmin<0) ansmin=0;
	ansmin=x-ansmin;
	ansmax-=(r[pos]-r[pos-1]);
	if (ansmax<0) ansmax=0;
	ansmax=x-ansmax;
	if (pos&1) {num-=(r[pos]-r[pos-1]);}
	else {num+=(r[pos]-r[pos-1]);}
	if (num<0) {minn=max(minn,-num);}
	if (num>0) {maxn=min(maxn,x-num);}
	pos++;
	}
	//printf ("%d %d\n",ansmin,ansmax);
	int tpans;
	if (a<=minn) {tpans=ansmin;}
	if (a>=maxn) {tpans=ansmax;}
	if (a>minn&&a<maxn) {tpans=ansmin+(a-minn)*((ansmin>ansmax)?-1:1);}
	tpans-=(t-r[pos-1]);
	if (tpans<0) tpans=0;
	if ((pos-1)&1) {tpans=x-tpans;}
	printf ("%d\n",tpans);
	}
	return 0;
}
	
	