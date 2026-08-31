#include<cmath>
#include<cstdio>
#include<vector>
#include<algorithm>

#define rep(i,n) for(int i=0;i<(n);i++)

using namespace std;

typedef long long ll;

int main(){
	ll n,m,a,b,p,q; scanf("%lld%lld%lld%lld%lld%lld",&n,&m,&a,&b,&p,&q);

	ll ans=m;
	if(a==1 && b==1){
		ans=min(ans,llabs(n*(p+q)-m));
		ll i=m/(p+q);
		for(int j=-3;j<=3;j++) if(0<=i+j && i+j<=n) ans=min(ans,llabs((i+j)*(p+q)-m));
	}
	else{
		int N;
		ll num[40];
		for(int k=0;;k++){
			long double tmp=p*pow(a,k)+q*pow(b,k);
			if(k==n || tmp>2e12){
				N=k;
				break;
			}
			num[k]=tmp;
		}
		if(N%2==1) num[N++]=0;

		vector<ll> half1,half2;
		rep(S,1<<N/2){
			bool ok1=true,ok2=true;
			ll sum1=0,sum2=0;
			rep(i,N/2) if(S>>i&1) {
				sum1+=num[i];
				sum2+=num[i+N/2];
				if(sum1>2e12) ok1=false;
				if(sum2>2e12) ok2=false;
			}
			if(ok1) half1.push_back(sum1);
			if(ok2) half2.push_back(sum2);
		}
		half1.push_back(0);
		half2.push_back(0);

		sort(half1.begin(),half1.end());
		sort(half2.begin(),half2.end());

		rep(i,half1.size()){
			int j=lower_bound(half2.begin(),half2.end(),m-half1[i])-half2.begin();
			if(j<half2.size()) ans=min(ans,llabs(half1[i]+half2[ j ]-m));
			if(j>0)            ans=min(ans,llabs(half1[i]+half2[j-1]-m));
		}
	}

	printf("%lld\n",ans);

	return 0;
}