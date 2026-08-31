#include <bits/stdc++.h>
using namespace std;

int main(void){
	int a,b,c;
	cin >> a >> b >> c;
	if(a+b == c || b+c == a || a+c==b)cout <<"Yes";
	else cout <<"No";
	return 0;
}