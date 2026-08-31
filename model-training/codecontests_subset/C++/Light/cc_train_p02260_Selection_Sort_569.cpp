#include <iostream>
using namespace std;

int main(){
	int n,x,a[101] = {},minj,count = 0;
	cin >> n;
	for(int i = 0;i < n;i++){
		cin >> x;
		a[i] = x;
	}

	for(int i = 0;i < n;i++){
		minj = i;
		for(int j = i;j < n;j++){
			if(a[j] < a[minj]){
				minj = j;
			}
		}
		swap(a[i],a[minj]);
		if(i != minj){
			count++;
		}
	}

	for(int i = 0;i < n;i++){
		if(i != n-1)cout << a[i] << " ";
		else cout << a[i] <<endl;
	}
	cout << count << endl;
	return 0;
}