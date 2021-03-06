package survive.status;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SurviveStatusReducer extends Reducer<Text,IntWritable,Text,IntWritable>
{
	public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException,InterruptedException
	{
		int sum = 0;
		for(IntWritable val:values)
		{
			sum +=1;
		}
		context.write(key,new IntWritable(sum));
	}
}
