#include<iostream>
#include<cstdio>
#include<algorithm>
#include<string>
#include<cstring>
using namespace std;
int main(){
	int n;
	while(cin >> n,n){
        int array[120] = {0};
        for(int i = 0; i < n; i++){
            cin >> array[i];
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(array[j] > array[j+1]){
                    array[j] ^= array[j+1];
                    array[j+1] ^= array[j];
                    array[j] ^= array[j+1];
                    cnt++;
                }
            }
        }
        cout << cnt << endl;
	}
	return 0;
}