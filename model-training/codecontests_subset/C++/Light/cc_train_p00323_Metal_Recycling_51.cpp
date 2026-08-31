#include <bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;
	
	int b[300000] = {};
	
	for(int i = 0;i < n;i++){
		int x, y;
		cin >> x >> y;
		b[x+y] += 1;
	}

	for(int i = 0;i < 300000-1;i++){
		b[i+1] += b[i] / 2;
		b[i] %= 2;
	}

	for(int i = 0;i < 300000;i++){
		if(b[i] != 0){
			cout << i << " " << 0 << endl;
		}
	}

	return 0;
}
