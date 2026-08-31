#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
int x,k,r[100050],s[100050],o[100050],w[100050],q,t,a;
int main(){
	scanf("%d%d",&x,&k);
	int i,j,v=-1;
	r[0]=o[0]=w[0]=0;
	s[0]=x;
	for(i=1;i<=k;i++){
		scanf("%d",&r[i]);
		int d=(r[i]-r[i-1])*v;
		w[i]=min(max(w[i-1]+d,0),x);
		s[i]=max(min(s[i-1]+d,x),0);
		o[i]=min(o[i-1]-min(0,w[i-1]+d),x);
		v*=-1;
	}
	i=0;	
	scanf("%d",&q);
	while(q--){
		scanf("%d%d",&t,&a);
		if(t>=r[k]) i=k;
		else{
			int n=k;
			while(i<n-1){
				int c=i+(n-i)/2;
				if(r[c]<t) i=c;
				else n=c;
			}
		}
		int ans=min(w[i]+max(a-o[i],0),s[i])+(t-r[i])*((i%2)*2-1);
		printf("%d\n",min(max(ans,0),x));
	}
	return 0;
}