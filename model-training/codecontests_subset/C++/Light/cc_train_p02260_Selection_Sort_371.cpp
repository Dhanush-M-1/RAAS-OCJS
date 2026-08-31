#include<cstdio>
#include<algorithm>
#include<iostream>

using namespace std;

int main()
{
	int N;
	cin >> N;
	int array[N];
	for(int i = 0; i < N; i++) cin >> array[i];

	// ソート
	int cnt = 0;
	for(int i = 0; i < N; i++)
	{
		int min = i;
		for(int j = i; j < N; j++)
			if(array[j] < array[min]) min = j;
		swap(array[i], array[min]);
		if(min != i) cnt++;
	}
	
	// 表示
	for(int i = 0; i < N-1; i++) printf("%d ", array[i]);
	printf("%d\n%d\n", array[N-1], cnt);
	
}