#include<iostream>
using namespace std;
typedef long long int ll;

int T;

ll GCD(ll a, ll b){
	if(b == 0) return a;
	else return GCD(b, a % b);
}

int main(){
	cin >> T;
	for(int i = 0; i < T; i++){
		ll A, B, C, D;
		cin >> A >> B >> C >> D;
		if(A < B || B > D){
			cout << "No" << endl;
			continue;
		}
		A %= B;
		if(A > C && C < B){
			cout << "No" << endl;
			continue;
		}
		ll g = GCD(B, D);
		if(B - g + (A % g) > C){
			cout << "No" << endl;
			continue;
		}
		cout << "Yes" << endl;
	}
	return 0;
}
