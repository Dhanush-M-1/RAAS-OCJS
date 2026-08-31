#include <iostream>

using namespace std;

long long gcd(long long a, long long b){
	if(a%b == 0) return b;
	return gcd(b, a%b);
}

bool solve(){
	long long A, B, C, D; cin >> A >> B >> C >> D;
	if(A < B) return false;
	if(D < B) return false;
	if(C >= B) return true;
	long long a = A%B;
	long long d = gcd(B, D);
	long long m = B - d + A%B%d; 
	return m <= C;
}

int main(){
	int T;
	while(cin >> T){
		for(int i=0;i<T;i++){
			cout << (solve() ? "Yes" : "No") << endl;
		}
	}
}