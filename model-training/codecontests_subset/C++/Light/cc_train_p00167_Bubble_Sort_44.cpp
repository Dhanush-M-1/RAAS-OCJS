#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)

int main(){
	int n;
	while(cin >> n , n){
		int ans = 0;
		vector<int> data(n);
		rep(i,n) cin >> data[i];
		rep(i,n){
			rep(j,n-1){
				if(data[j] > data[j+1]){
					swap(data[j],data[j+1]);
					ans++;
				}
			}
		}
		cout << ans << endl;
	}
}