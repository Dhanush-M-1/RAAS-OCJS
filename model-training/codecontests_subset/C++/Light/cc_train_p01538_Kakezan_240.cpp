#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

vector<int> ans;
int main(){
	int q;
	cin >> q;
	
	for(int i = 0;i < q;i++){
		int n;
		cin >> n;
		int tans = 0;
		vector<int> used;
		while(n >= 10){
			int div = 10;
			int next = 0;
			for(int i = 0;i < 6;i++){
				int l = n/div;
				int r = n%div;
				if(l != 0){
					next = max(next,l*r);
				}
				div*=10;
			}
			if(find(used.begin(),used.end(),next) != used.end()){
				tans = -1;
				break;
			}
			used.push_back(next);
			n = next;
			tans++;
		}
		ans.push_back(tans);
	}
	
	for(int i = 0;i < ans.size();i++) cout << ans[i] << endl;
	return 0;
}