#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cstring>
using namespace std;
typedef long long ll;
inline ll MIN(ll x,ll y){
	return x<y?x:y;
}
inline ll MAX(ll x,ll y){
	return x<y?y:x;
}
inline ll ABS(ll x){
	return x>=0?x:-x;
}
const ll mxn=5010;
ll I,i,j,k;
ll x,y,z,xx,xy,xz,yx,yy,yz;
bool blx,bly,blz;
ll T,m,n,p;
ll t[mxn],s[mxn];
ll ans;
ll f[mxn];
int main(){
	scanf("%lld",&T);
	for(I=1;I<=T;I++){
		scanf("%lld",&n);
		for(i=1;i<=n;i++){
			scanf("%lld",&t[i]);
		}
		for(i=1;i<=n;i++){
			scanf("%lld",&s[i]);
		}
		for(i=1;i<=n;i++){
			f[i]=0;
		}
		for(i=2;i<=n;i++){
			for(j=1;j<i;j++){
				if(t[j]!=t[i]){
					f[i]=MAX(f[i],f[j]+ABS(s[i]-s[j]));
				}
			}
			x=0;
			for(j=i-1;j;j--){
				if(t[j]!=t[i]){
					y=f[j];
					f[j]=MAX(f[j],x+ABS(s[i]-s[j]));
					x=MAX(x,y+ABS(s[i]-s[j]));
				}
			}
		}
		ans=0;
		for(i=1;i<=n;i++){
			ans=MAX(ans,f[i]);
		}
		printf("%lld\n",ans);
	}
	return 0;
}