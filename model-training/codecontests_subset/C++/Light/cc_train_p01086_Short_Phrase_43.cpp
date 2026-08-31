#include<bits/stdc++.h>
#include<string.h>


using namespace std;
typedef long long ll;
ll n,m,a,b;
ll i,j,k;
ll x[100005],y[100005];
char s[100];

bool solve(){
	cin >> n ;
	if(n == 0){
		return false;
	}
	ll ans = 0;
	for(i=0;i<100;i++){
		x[i] = 0;
		y[i] = 0;
	}
	for(i=0;i<n;i++){
		cin >> s;
		m = strlen(s);
		x[i] = m;
	}
	for(i=0;i<n;i++){
		ll sum = 0;
		ll a = 0;
		bool ok = false;
		for(j=i;j<n;j++){
			sum += x[j];
			if(sum == 5)a++;
			if(sum == 12)a++;
			if(sum == 17)a++;
			if(sum == 24)a++;
			if(sum == 31){
				a++;
				if(a == 5){
					ok = true;
					break;
				}else{
					ok = false;
					break;
				}
			}
			if(sum >= 32 && a <= 4){
				ok = false;
				break;
			}
		}
		if(ok){
			cout << i+1 << endl;
			return true;
		}else{
			//cout << "dame" << endl;
		}
	}

}


int main(){
	while(solve());
	return 0;
	
}
