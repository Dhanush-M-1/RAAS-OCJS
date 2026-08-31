#include <bits/stdc++.h>
using namespace std;

string s[101];
int n;

int main(){
while(1){	
	
	cin >> n;
	if(n == 0) break;
	for(int i=0; i<n; i++) cin >> s[i];
	
	int r_foot = 0;
	int l_foot = 0;
	int past_l = 0;
	int past_r = 0;
	
	int ans = 0;
	for(int i=0; i<n; i++){
		if(s[i] == "lu") l_foot++;
		else if(s[i] == "ru") r_foot++;
		else if(s[i] == "ld") l_foot--;
		else if(s[i] == "rd") r_foot--;
		
		if(l_foot != past_l and r_foot != past_r){
			ans++;
			past_r = r_foot;
			past_l = l_foot;
		}
	}
	
	cout << ans << endl;
	
}//end
	
	return 0;
}
