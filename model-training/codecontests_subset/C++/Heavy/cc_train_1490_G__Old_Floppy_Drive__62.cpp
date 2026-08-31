#include<iostream>
#include<algorithm>
using namespace std;
const int N=2e6+5;
typedef long long ll;
long long n,m;
long long a[N],s[N],v[N],id[N];
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		
		scanf("%lld%lld",&n,&m);
		for(int i=0;i<=n;i++)s[i]=v[i]=0;
	    ll tot=0;
		for(int i=1;i<=n;i++){
		scanf("%lld",&a[i]);
		s[i]=s[i-1]+a[i];
	    if(!tot||s[i]>v[tot]) v[++tot]=s[i],id[tot]=i;
		
		}
		while(m--){
		 ll q;
		 scanf("%lld",&q);                
		 if(q>v[tot]&&s[n]<=0)puts("-1 ");//公式：r*s[n]+max{s[i]}>=q 由于延长后的序列是单调的，所以当 s[n]<=0，截距max{s[i]}<q时公式无解 
		 else{
		 	int r=0;
		 	if(v[tot]<q)//r*s[n]>=q-max{s[i]},max{s[i]}<q时r>=1 
		 	   r=(q-v[tot]+s[n]-1)/s[n];// 向下取整 
		 	q-=r*s[n];
		 	printf("%lld ",r*n+id[lower_bound(v+1,v+1+tot,q)-v]-1);//二分
		 }
		 
	}
	puts("");
}
	
	return 0;
}
   			      	   		   	 		    	