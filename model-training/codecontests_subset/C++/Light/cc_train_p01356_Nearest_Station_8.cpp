#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

typedef long long ll;

int main(){
	ll n,m,a,b,p,q;
	cin >> n >> m >> a >> b >> p >> q;
	
	if(a == 1 && b == 1){
		ll x = m/(p+q);
		if(x >= n)cout << m-n*(p+q) << endl;
		else cout << min ( m-x*(p+q) , (x+1)*(p+q)-m ) << endl;
	}
	else {
		vector<ll> vec;
		ll s = 1 , t = 1;
		for(int i = 0 ; i < n ; i ++){
			vec.push_back(p*s+q*t);
			if(p*s+q*t > m)break;
			s *= a;
			t *= b;
		}
		int N = vec.size();
		vector<ll> A,B;
		A.push_back(0);
		for(int i = 0 ; i < N/2 ; i ++){
			int x = A.size();
			for(int j = 0 ; j < x ; j ++){
				A.push_back(vec[i]+A[j]);
			}
		}
		B.push_back(0);
		for(int i = N/2 ; i < N ; i ++){
			int x = B.size();
			for(int j = 0 ; j < x ; j ++){
				B.push_back(vec[i]+B[j]);
			}
		}
		sort(B.begin(),B.end());
		B.erase(unique(B.begin(),B.end()),B.end());
		ll ret = m;
		for(int i = 0 ; i < A.size() ; i ++){
			int x = upper_bound(B.begin(),B.end(),m-A[i])-B.begin();
			if(x < B.size())ret = min ( ret , A[i]+B[x]-m );
			x --;
			ret = min ( ret , m-A[i]-B[x] );
		}
		cout << ret << endl;
	}
}