#include<iostream>
#include<vector>
#include<string>

using namespace std;
vector<int> ans;

int main(){
	while(true){
		int n;
		cin >> n;
		if(n == 0) break;
		
		string word[40];
		for(int i = 0;i < n;i++){
			cin >> word[i];
		}
		
		int tanku[] = {5,7,5,7,7};
		int ini = 0;
		for(int i = 0;i < n;i++){
			if(ini != 0) break;
			int kun = 0;
			int kulen = 0;
			for(int j = i;j < n;j++){
				kulen += word[j].size();
				if(kulen == tanku[kun]){
					kun++;
					kulen = 0;
					if(kun >= 5){
						ini = i+1;
						break;
					}
				}else if(kulen > tanku[kun]){
					break;
				}
			}
		}
		ans.push_back(ini);
	}
	
	for(int i = 0;i < ans.size();i++) cout << ans[i] << endl;
	
	return 0;
}
