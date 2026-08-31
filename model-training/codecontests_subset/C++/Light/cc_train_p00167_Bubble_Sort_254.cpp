#include<iostream>
using namespace std;

int main(){

	int n, cnt, tmp, v[100];
	
	while(cin >> n){
		if(n == 0) break;
		cnt = 0;
		
		for(int i=0; i<n; i++){
			cin >> v[i];
		}
		
		for(int i=n-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(v[j] > v[j+1]){
					tmp = v[j];
					v[j] = v[j+1];
					v[j+1] = tmp;
					cnt++;
				}
			}
		}
		
		cout << cnt << endl;
	}

	return 0;

}