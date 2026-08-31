#include <cstdio>
#include <algorithm>
#define MAX 100
using namespace std;

int bubbleCount(int* array, int n);

int main(){
	int n;
	while(scanf("%d", &n)){
		if(n == 0) break;
		int array[MAX];
		fill(array, array + MAX, 0);
		for(int i = 0; i < n; i++) scanf("%d", &array[i]);
		
		printf("%d\n", bubbleCount(array, n));
	}
	return 0;
}

int bubbleCount(int* array, int n){
	bool flag = true;
    int temp, count = 0;
    while(flag){
        flag = false;
        for(int i = n - 1; i > 0; i--)
        	if(array[i] < array[i - 1]){
            	temp = array[i];
            	array[i] = array[i - 1];
            	array[i - 1] = temp;
            	flag = true;
            	count++;
        	}
    	}
    return count;
}