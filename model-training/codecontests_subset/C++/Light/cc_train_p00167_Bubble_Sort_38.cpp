#include <iostream>
using namespace std;

int main(){
	int n,i,a[100],j,m,tmp,count;
	while(cin >> n && n){
		count = 0;
		for(i = 0;i < n;i++){
			cin >> m;
			a[i] = m;
		}
		for(i = 0;i < n-1;i++){
			for(j = i+1;j < n;j++){
				if(a[i] > a[j]){
					tmp = a[j];
					a[j] = a[i];
					a[j] = tmp;
					count++;
				}
			}
		}
		cout << count << endl;
	}
	return 0;
}