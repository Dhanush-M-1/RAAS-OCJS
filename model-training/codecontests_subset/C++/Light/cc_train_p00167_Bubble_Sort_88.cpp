#include<iostream>
#include<cstdio>
#include<cstdlib>

using namespace std;

int bubble(int n, int bubble[], int count);

int main(void)
{
	int ans, n;
	while(cin >> n, n){
		int num[100];
		for(int i = 0; i < n; i++){
			cin >> num[i];
		}
		ans = bubble(n, num, 0);
		cout << ans << endl;
	}
	
	return 0;
}

int bubble(int n, int bubble[], int count)
{
	int temp = n;
	for(int ii = 0; ii < n; ii++){
		for(int i = 0; i < temp-1; i++){
			if(bubble[i] > bubble[i+1]){
				count++;
				int temp;
				temp = bubble[i];
				bubble[i] = bubble[i+1];
				bubble[i+1] = temp;
			}
		}
		temp--;
	}
	
	return count;
}