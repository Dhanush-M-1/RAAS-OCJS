#include <bits/stdc++.h>
#define rep(i,l,n) for(int i=l;i<n;i++)
#define rer(i,l,n) for(int i=l;i<=n;i++)
#define all(a) a.begin(),a.end()
#define o(a) cout<<a<<endl
#define pb(a) push_back(a)
#define mk(a,b) make_pair(a,b)
#define fi first
#define se second
using namespace std;
typedef long long ll;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef pair<int,int> pii;

double cross_product(double x1,double y1,double x2,double y2){
	return x1*y2-x2*y1;
}

int main(){
	double x[4],y[4];
	while(~scanf("%lf,%lf",&x[0],&y[0])){
		rep(i,1,4) scanf(",%lf,%lf",&x[i],&y[i]);
		double c=1;
		rep(i,0,4){
			c*=cross_product(x[(i+1)%4]-x[i],y[(i+1)%4]-y[i],x[(i+2)%4]-x[(i+1)%4],y[(i+2)%4]-y[(i+1)%4]);
			//o(c[i]);
		}
		if(c>0) o("YES");
		else o("NO");
	}
}