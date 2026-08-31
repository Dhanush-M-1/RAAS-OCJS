#include<iostream>
using namespace std;

int main(){
	int p;
	int n[1000000];
	while(cin >>  p, p){
		int ans = 0;
		for(int i=0; i < p; i++){
			cin >> n[i];
		}
		for(int i=0; i < p; i++){
			for(int j = 0; j < p-i-1; j++){
				if(n[j] > n[j+1]){
					swap(n[j], n[j+1]);
					ans++;
				}
			}
		}
		cout << ans << endl;
	}
}