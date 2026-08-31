#include <iostream>
#include <algorithm>

using namespace std;

int main(void){
	int n,t;
	while(cin >> n && n){
		int a[n];
		int r=0;
		for(int i=0;i<n;i++){
			cin >> a[i];
		}
		for(int i=n-1;i>0;i--){
			for(int j=1;j<=i;j++){
				if(a[j-1]>a[j]){
					swap(a[j-1],a[j]);
					r++;
				}
			}
		}
		cout << r << endl;
	}
}