#include<bits/stdc++.h>

using namespace std;

const int N=100010;
int r[N],tup[N],tdn[N];
int n,X;
int q;
int a,t;
int s[N];

int getlw(int p){
    int L=0,R=n;
    while(L<R){
	//cout<<L<<' '<<R<<endl;
	int mid=(L+R+1)>>1;
	if(r[mid]>p)R=mid-1;
	else{
	    L=mid;
	}
    }
    return L;
}

int main()
{
    //freopen("c.in","r",stdin);
    //freopen("c.out","w",stdout);
    scanf("%d",&X);
    tup[0]=X;
    scanf("%d",&n);
    for(int i=1;i<=n;i++){
	scanf("%d",&r[i]);
	if(i%2){
	    s[i]=s[i-1]-r[i]+r[i-1];
	    tup[i]=tup[i-1]-r[i]+r[i-1];
	    tdn[i]=tdn[i-1]-r[i]+r[i-1];
	}
	else{
	    s[i]=s[i-1]+r[i]-r[i-1];
	    tup[i]=tup[i-1]+r[i]-r[i-1];
	    tdn[i]=tdn[i-1]+r[i]-r[i-1];
	}
	if(tup[i]>X)tup[i]=X;
	else if(tup[i]<0)tup[i]=0;
	if(tdn[i]>X)tdn[i]=X;
	else if(tdn[i]<0)tdn[i]=0;
	//cout<<tup[i]<<' '<<tdn[i]<<endl;
    }
    scanf("%d",&q);
    while(q--)
    {
	scanf("%d%d",&t,&a);
	int p=getlw(t);
	//cout<<p<<endl;
	int up,dn,now;
	if((p+1)%2){
	    up=tup[p]-t+r[p];
	    dn=tdn[p]-t+r[p];
	    now=s[p]-t+r[p];
	}else{
            up=tup[p]+t-r[p];
	    dn=tdn[p]+t-r[p];
	    now=s[p]+t-r[p];
	}
	now+=a;
	if(up>X)up=X;
	else if(up<0)up=0;
	if(dn>X)dn=X;
	else if(dn<0)dn=0;
	//cout<<up<<'|'<<now<<'|'<<dn<<endl;
	if(now>up)now=up;
	if(now<dn)now=dn;
	printf("%d\n",now);
    }
}

