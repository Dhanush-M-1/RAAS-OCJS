#include<iostream>
#include<cstring>
#include<cstdio>
#include<algorithm>
#include<cmath>
#include<set>
#include<bitset>
#include<map>

#define fo(i,a,b) for(int i=a;i<=b;i++)
#define fd(i,a,b) for(int i=a;i>=b;i--)

using namespace std;

typedef long long LL;
typedef double db;

int get(){
	char ch;
	while(ch=getchar(),(ch<'0'||ch>'9')&&ch!='-');
	if (ch=='-'){
		int s=0;
		while(ch=getchar(),ch>='0'&&ch<='9')s=s*10+ch-'0';
		return -s;
	}
	int s=ch-'0';
	while(ch=getchar(),ch>='0'&&ch<='9')s=s*10+ch-'0';
	return s;
}

const int N = 1e+5+5;

int n,q,k,X;
int rev[N];
int X0,Y0,X1,s,now;

void turn(int t){
	int v=(t-now);
	if (s==1){
		Y0+=v;
		int Y1=Y0+X1-X0;
		if (Y0>=X)X0=X,X1=X,Y0=X;
		else
			if (Y1>X)X1-=Y1-X;
	}
	else{
		Y0-=v;
		int Y1=Y0+X1-X0;
		if(Y1<=0)X0=X,X1=X,Y0=0;
		else
			if (Y0<0)X0-=Y0,Y0=0;
	}
	now=t;
}

int main(){
	X=get();
	k=get();
	fo(i,1,k)rev[i]=get();
	X0=0,Y0=0,X1=X,now=0,s=-1;
	q=get();
	int w=1;
	fo(i,1,q){
		int t=get(),a=get();
		while(w<=k&&rev[w]<t){
			turn(rev[w++]);
			s=-s;
		}
		turn(t);
		if (a<X0)printf("%d\n",Y0);
		if (a>=X0&&a<=X1)printf("%d\n",Y0-X0+a);
		if (a>X1)printf("%d\n",Y0+X1-X0);
	}
	return 0;
}