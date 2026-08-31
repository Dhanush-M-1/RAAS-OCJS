#include<bits/stdc++.h>
using namespace std;
int main(){
	int n;
	cin >> n;
	map<pair<char, int>, int> m;
	for (int i=0;i<n;i++){
		char c; int x;
		cin >> c >> x;
		m[{c,x}] = 1;
	}
	for (int i=1;i<=13;i++){
		if (!m[{'S',i}]){
			cout << 'S' << ' ' << i << endl;
		}
	}
	for (int i=1;i<=13;i++){
		if (!m[{'H',i}]){
			cout << 'H' << ' ' << i << endl;
		}
	}
	for (int i=1;i<=13;i++){
		if (!m[{'C',i}]){
			cout << 'C' << ' ' << i << endl;
		}
	}
	for (int i=1;i<=13;i++){
		if (!m[{'D',i}]){
			cout << 'D' << ' ' << i << endl;
		}
	}
}
