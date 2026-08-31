#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int main(){
	
	while(true){
		
		int n;
		
		int a[200];
		
		cin >> n;
		
		if(n == 0){
			break;
		}
		
		int ans = 0;
		
		for(int i = 0; i < n; i++){
			cin >> a[i];
		}
		
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(a[i] > a[j]){
					ans++;
				}
			}
		}
		
		cout << ans << endl;
		
	}
	
	return 0;
}