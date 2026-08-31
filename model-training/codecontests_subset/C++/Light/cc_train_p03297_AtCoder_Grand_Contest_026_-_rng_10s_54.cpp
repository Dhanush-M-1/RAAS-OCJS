#include <iostream>
using namespace std;
typedef long long ll;
ll T,A,B,C,D;

ll gcd(ll a,ll b){
	if(a%b==0) return b;
	else return gcd(b,a%b);
}

int main(){
	cin >> T;
	for(int i=0;i<T;i++){
		cin >> A >> B >> C >> D;
		if(A<B) cout << "No" << endl;
		else if(D<B) cout << "No" << endl;
		else if(B<=C) cout << "Yes" << endl;
		else{
			ll g = gcd(B,D);
			if(B-g+(A%g)<=C) cout << "Yes" << endl;
			else cout << "No" << endl;
		}
	}
}