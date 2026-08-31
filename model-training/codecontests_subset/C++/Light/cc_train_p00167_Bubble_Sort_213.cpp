#include <iostream>

using namespace std;

int n;
int v[10000];

int main(){
		
	while(cin>>n, n){
		
		for(int i=0; i<n; ++i){
			cin>>v[i];
		}

		int step = 0;

		for(int i=n; i>0; --i){
			for(int j=0; j<i-1; ++j){
				
				if(v[j] > v[j+1]){
					swap(v[j], v[j+1]);
					step++;
				}
			}
		}

		cout << step << endl;
	}

	return 0;
}