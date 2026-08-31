#include<cstdio>
#include<algorithm>
#define fo(i,a,b) for(i=a;i<=b;i++)
using namespace std;
const int maxn=100000+10;
struct dong{
	int t,a;
} ask[maxn];
int p[maxn],ans[maxn];
int i,j,k,l,t,n,m,f,a,b,c,d,e,X;
bool czy;
int get(int x){
	if (czy) return e;
	if (x<=a) return b;
	else if (x>=c) return d;
	else return (x-a)+b;
}
void change(int f,int t){
	if (czy){
		e+=f*t;
		e=max(0,min(X,e));
		return;
	}
	if (f==-1){
		if (d-t<=0){
			czy=1;
			e=0;
			return;
		}
		if (t>=b){
			a+=t-b;
			b=0;
			d-=t;
		}
		else{
			b-=t;
			d-=t;
		}
	}
	else{
		if (b+t>=X){
			czy=1;
			e=X;
			return;
		}
		if (d+t>=X){
			b+=t;
			c-=d+t-X;
			d=X;
		}
		else{
			b+=t;
			d+=t;
		}
	}
}
int main(){
	scanf("%d",&X);
	scanf("%d",&n);
	fo(i,1,n) scanf("%d",&p[i]);
	scanf("%d",&m);
	fo(i,1,m) scanf("%d%d",&ask[i].t,&ask[i].a);
	j=0;
	a=0;b=0;c=X;d=X;
	f=-1;
	fo(i,1,n){
		while (j<m&&ask[j+1].t<p[i]){
			j++;
			k=ask[j].a;
			ans[j]=max(0,min(X,get(k)+f*(ask[j].t-p[i-1])));
		}
		change(f,p[i]-p[i-1]);
		f*=-1;
	}
	while (j<m){
		k=ask[++j].a;
		ans[j]=max(0,min(X,get(k)+f*(ask[j].t-p[n])));
	}
	fo(i,1,m) printf("%d\n",ans[i]);
}