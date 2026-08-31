#include <bits/stdc++.h>
using namespace std;

int main(){
	int a,b;
	cin >> a >>b;
	if(a<=9&&a>=1&&b>=1&&b<=9)cout << a*b;
	else cout << -1;
}