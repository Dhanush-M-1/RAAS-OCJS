#include <bits/stdc++.h>
using namespace std;

int n;

int main(){
//	cin.tie(0);
//	ios::sync_with_stdio(false);
	while(1){
		cin >> n;
		if(n == 0) return 0;
		int a = 0, b = 0, c = 0;
		for(int i=0; i<n; ++i){
			string s;
			cin >> s;
			if(s == "lu") b += 2;
			else if(s == "ru") b += 1;
			else if(s == "ld") b -= 2;
			else b -= 1;
			if((b == 0 || b == 3) && b != c){
				c = b;
				++a;
			}
		}
		cout << a << "\n";
	}
}
