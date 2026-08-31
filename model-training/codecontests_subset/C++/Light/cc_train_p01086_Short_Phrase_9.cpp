#include <bits/stdc++.h>
using namespace std;

vector<int> v;
int d[5] = {5 ,7, 5, 7, 7};

int main(){
while(1){//start	
	
	int n;
	cin >> n;
	if(n == 0) break;
	for(int i = 0; i < n; i++){
		string s;
		cin >> s;
		v.push_back((int)s.size());
	}
	
	//debug
	//for(int i = 0; i < n; i++) cout << v[i] << endl;
	
	int ans = 0;
	for(int i = 0; i < n - 1; i++){
		int len = 0;
		int tmp = 0;
		int next = 0;
		for(int j = i; j < n; j++){
			len += v[j];
			tmp += v[j];
			if(next == 4 and len == 31){
				ans = i + 1;
				goto end;
			}
			else if(d[next] == tmp){
				//cout << tmp << endl;
				tmp = 0;
				next++;
			}
		}
		//cout << endl;
	}
	
	end:
	cout << ans << endl;
	
	v.clear();
}//end
	return 0;
}
