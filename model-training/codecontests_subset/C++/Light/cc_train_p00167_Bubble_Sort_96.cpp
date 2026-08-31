#include <iostream>
using namespace std;

void swap( int* a, int* b )
{
  int tmp;
  tmp = *a;
  *a = *b;
  *b = tmp;
}

int BubbleSort( int* lst, int length )
{
  int count = 0;
  for (int i=1; i<length; i++)
  {
    for (int j=0; j<length-i; j++)
    {
      if ( lst[j] > lst[j+1] )
      {
        swap( &lst[j], &lst[j+1] );
        count++;
      }
    }
  }
  return count;
}

int main()
{
  while(true)
  {
    int n;
    cin >> n;
    if ( n == 0 ) break;
    int* arr = new int[n];
    for (int i=0; i<n; i++)
    {
      cin >> arr[i];
    }

    int count = BubbleSort( arr, n );

    cout << count << endl;

    delete[] arr;
  }
}