#include<bits/stdc++.h>
using namespace std;
#define i64 long long int
i64 gcd(i64 x,i64 y){
	return y?gcd(y,x%y):x;
}
bool chk(){
	i64 A,B,C,D;
	cin >> A >> B >> C >> D;
	if(D<B || A<B)return false;
	if(C>=B-1)return true;
	i64 g=gcd(B,D);
	A%=g;
	return B-g+A <= C;
}
int main(){
	int _;
	for(cin >> _; _--;){
		cout << (chk()? "Yes" :"No") << endl;
	}
	return 0;
}
