#include <bits/stdc++.h>
using namespace std;

int main(void){
	int n;
	int t[] = {5,7,5,7,7};
	while(cin >> n, n){
		vector<int> v(n);
		for(int i = 0; i < n; ++i){
			string s;
			cin >> s;
			v[i] = s.size();
		}
		for(int i = 0; i < n; ++i){
			bool a = true;
			int j = i;
			int tn = 0;
			while(tn < 5){
				int sum = 0;
				while(sum < t[tn]){
					sum += v[j];
					j++;
					if(j==n)break;
				}
				if(sum == t[tn]){
					tn++;
				}else{
					a = false;
					break;
				}
			}
			if(a && tn==5){
				cout << i+1 << endl;
				break;
			}
		}
	}
	return 0;
}
