#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    while(cin >> n, n){
	int len[] = {5, 7, 5, 7, 7};
	string w[44];
	for(int i = 0; i < n; i++) cin >> w[i];
	int ans = 0;
	for(int i = 0; i < n; i++){
	    int cnt = 0, idx = 0;
	    for(int j = i; j < n; j++){
		cnt += w[j].size();
		if(cnt == len[idx]){
		    cnt = 0, idx++;
		    if(idx == 5) break;
		}else if(cnt > len[idx]){ idx = -1; break;}
	    }
	    if(idx == 5){ ans = i; break;}
	}
	cout << ans+1 << endl;
    }
    return 0;
}