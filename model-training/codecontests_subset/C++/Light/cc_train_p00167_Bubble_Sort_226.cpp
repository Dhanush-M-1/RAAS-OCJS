#include <iostream>
using namespace std;

int data[101];
int main()
{
	int n;
	while(cin >> n){
		if(n==0)
			break;
		for(int i=0;i<n;i++){
			cin >> data[i];
		}
		int cnt = 0;
		for(int i=0;i<n;i++){
			for(int j=n-1;j>i;j--){
				if(data[j] < data[j-1]){
					int tmp = data[j];
					data[j] = data[j-1];
					data[j-1] = tmp;
					cnt++;
				}
			}
		}
		
		cout << cnt << endl;
	}
	return 0;
}