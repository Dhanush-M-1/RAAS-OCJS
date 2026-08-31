#include <bits/stdc++.h>

using namespace std;

int d[5] = {5,7,5,7,7};

int main(){
	int n;
	while(cin >> n,n){
		vector<int> v;
		for(int i=0;i<n;i++){
			string s;
			cin >> s;
			v.emplace_back(s.size());
			//cout << s.size() << endl;
		}
		int sum=0;
		int idx=0;
		int start=0;
		for(int unsigned i=0;i<v.size();i++){
			sum+=v[i];
			//cout << v[i] << " " << sum << " " << d[idx] << " " << i << " " << " " << idx << " " << start << endl;
			if(sum == d[idx]){
				idx++;
				sum=0;
			} else if(sum > d[idx]){
				idx=0;
				i = start;
				start=i+1;
				sum=0;
			}
			if(idx >= 5){
				cout << start+1 << endl;
				break;
			}
		}
		//cout << endl;
	}
	return 0;
}