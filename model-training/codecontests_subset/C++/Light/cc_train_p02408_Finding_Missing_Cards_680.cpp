#include <bits/stdc++.h>
using namespace std;
int main(){
	int n, x, t;
	char ch, c[4] = {'S', 'H', 'C', 'D'};
	bool b[60];
	memset(b, false, sizeof(b));
	cin >> n;
	for(int i=1; i<=n; i++){
		cin >> ch >> x;
		for(int j=0; j<4; j++){
			if(ch==c[j]){
				t = j*13+x;
				break;
			}
		}
		b[t] = true;
	}
	for(int i=1; i<=52; i++){
		if(!b[i]){
			cout << c[(i-1)/13] << " " << (i-1)%13+1 << endl;
		}
	}
	return 0;
}
