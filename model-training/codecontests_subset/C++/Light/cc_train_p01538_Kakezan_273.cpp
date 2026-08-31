#include <bits/stdc++.h>

using namespace std;

int main(){
	int q;
	cin >> q;
	for(int i=0;i<q;i++){
		int n;
		cin >> n;
		int c=0;
		while(n>=10){
			string s = to_string(n);
			n=0;
			for(int unsigned j = 1;j<s.size();j++){
				n = max(n,stoi(s.substr(0,j))*stoi(s.substr(j)));
			}
			c++;
		}
		cout << c << endl;
	}
	return 0;
}